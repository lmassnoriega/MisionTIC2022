from flask_wtf import FlaskForm
from wtforms import StringField, BooleanField, SubmitField, PasswordField
from wtforms.validators import DataRequired
from wtforms.fields.html5 import EmailField

#Clase manipulación de campos
class Contactenos(FlaskForm):
    nombre =StringField('Nombre', validators=[DataRequired('No dejar vacion, completar')])
    correo = EmailField('Correo', validators=[DataRequired('No dejar vacion, completar')])
    mensaje = StringField('Mensaje', validators=[DataRequired('No dejar vacion, completar')])
    enviar = SubmitField('Enviar Mensaje')