#Comentario
from logging import error
import os
from flask import Flask, jsonify, render_template, flash, request, redirect,url_for



#Importar librería Yagmail
import yagmail as yagmail

#Usar el archivo Utils
import utils

#Formulario con las validaciones
from formulario import Contactenos
from mensaje import mensajes

#Importar la clase conexion
from db import get_db

app = Flask(__name__)
app.secret_key = os.urandom(24)

@app.route('/')
def index():
    return render_template('register.html')

#Funcion Login
@app.route('/login', methods=('GET', 'POST'))
def login():
    try:
        if request.method == 'POST':
            db = get_db()
            error = None
            username = request.form['username']
            password = request.form['password']
            if not username:
                error = 'Debes ingresar el usuario'
                flash(error)
                return render_template('login.html')
            if not password:
                error = 'Contraseña requerida'
                flash(error)
                return render_template('login.html')
            
            user = db.execute(
                'Select * From Usuario Where usuario = ? AND contraseña = ?',(username, password)
            ).fetchone()
            
            if user is None:
                error = 'Usuario y/o contraseña inválido. Intenta nuevamente'
            else:
                return redirect('mensaje')
            flash(error)
        return render_template('login.html')
    except:
        return render_template('login.html')
            

#Función Register
@app.route('/register', methods=('GET','POST'))
def register():
   try:
       if request.method == 'POST':
           username = request.form['username']
           password = request.form['password']
           email = request.form['correo']
           name = request.form['nombre']
           
           error = None

           #Conexion a BD
           db = get_db()

           if not name:
                error = 'Debes ingresar el nombre'
                flash(error)
                return render_template('register.html')

           if not username:
                error = 'Debes ingresar el nombre de usuario'
                flash(error)
                return render_template('register.html')

           if not utils.isUsernameValid(username):
               error = "El usuario debe ser alfanumérico o incluir solo '.','_','-'"
               flash(error)
               return render_template('register.html')

           if not utils.isPasswordValid(password):
                error = "La contraseña debe contener al menos una minúscula, una mayúscula, un número y 8 caracteres"    
                flash(error)
                return render_template('register.html')

            
           if not utils.isEmailValid(email):
                error = 'Correo inválido'    
                flash(error)
                return render_template('register.html')

           if db.execute('Select id from usuario where correo = ?', (email) ).fetchone() is not None:
                error = 'El correo ya existe'.format(email)
                flash(error)
                return render_template('register.html')
             
           print(error)

           db.execute('insert into usuario (nombre, usuario, correo, contraseña) values (?,?,?,?)',
                (name, username, email, password)                                 
            )
           db.commit()

       return render_template('register.html')
   except:
        return render_template('register.html')

#Ruta para Contacto
@app.route('/contacto', methods=('GET', 'POST'))
def contacto():
    form = Contactenos()
    return render_template ('contacto.html', titulo='Contactenos', form=form)

#Ruta para el mensaje
@app.route('/mensaje', methods=('GET', 'POST'))
def mensaje():
    return jsonify({'mensajes': mensajes})

if __name__ == '__main__':
    app.run()