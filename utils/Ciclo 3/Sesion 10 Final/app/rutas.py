from app import app
from flask import render_template
from app.forms import FormInicio
@app.route('/')
@app.route('/index')
def index():
  usuario = {'usuario':'...'}
  comentarios = [
    {
      'autor':{'usuario':'...'},
      'comentario':'...'
    },
    {
      'autor':{'usuario':'...'},
      'comentario':'...'
    }
  ]
  return render_template('index.html', titulo="Inicio", usuario=usuario, comentarios=comentarios)

@app.route('/login')
def login():
  form = FormInicio()
  return render_template('iniciar_sesion.html', 
titulo='Iniciar Sesión', form=form)
