#Comentario
import os
from flask import Flask, render_template, flash, request, redirect,url_for 


#Importar librería Yagmail
import yagmail as yagmail

#Usar el archivo Utils
import utils

app = Flask(__name__)
app.secret_key = os.urandom(24)

@app.route('/')
def index():
    return render_template('register.html')

@app.route('/login')
def login():
    return render_template('login.html')

#Función Register
@app.route('/register', methods=('GET','POST'))
def register():
   try:
       if request.method == 'POST':
           username = request.form['username']
           password = request.form['password']
           email = request.form['correo']
           error = None

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

           #Envio de correo con sus información personal
           yag = yagmail.SMTP('dfmarin@uninorte.edu.co','passW1234')
           yag.send(to=email, subject='Activa tu cuenta',
                contents='Bienvenido, usa el siguiente Link para activar tu cuenta')
           flash('Revisa tu correo para activar cuenta')
           return render_template('login.html')

       print("Llegó al final")
       return render_template('register.html')
   except:
        return render_template('register.html')
