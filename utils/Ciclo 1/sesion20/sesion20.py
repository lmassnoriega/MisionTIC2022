"""
Manejo de archivos

Python también cuenta con librerías adicionales para el manejo de archivos. Entre ellos se incluyen 
la librería pandas e incluso la librería csv exclusiva para archivos separados por comas.

Vamos a ver ejemplos usando estas librerías.

En este caso vamos a leer la información de un archivo matrizAsignacion.csv e imprimirlo. 
"""
import csv

def testCSV():
    archivo =  open('matrizAsignacion.csv', mode='r', encoding='utf-8-sig' ) 
    lector = csv.reader(archivo) #Retorna un objeto con las filas del csv
    
    for fila in lector: #Este va a recorrer cada fila
        print(fila)
        for i in fila:  #Este recorre cada valor en cada fila [i] representa cada elemento separado por ,
             print(i)

testCSV()

#Como vemos, esta librería nos permite recorrer el archivo y los valores en un csv sin necesidad de 
#separar los valores.
#
#CSV también cuenta con una opción para escribir un archivo. 
#Vamos ahora a leer el archivo y escribirlo en otro archivo adicionando una columna al final con el 
#valor "Nuevo".
import csv

def testIOcsv():
    archivo =  open('matrizAsignacion.csv', mode='r', encoding='utf-8-sig' ) 
    nuevoArchivo = open('archivoResultado.csv', mode='w', encoding='utf-8-sig' )
    
    lector = csv.reader(archivo) #Retorna un objeto con las filas del csv para ser leidas
     
    escritor = csv.writer(nuevoArchivo) #Retorna un objeto para escribir en csv
    
    for fila in lector: #Este va a recorrer cada fila del lector (Trabaja como una lista)
        fila.append("Nuevo")
        escritor.writerow(fila) # Este escribe cada fila en

testIOcsv()

#Actividad 1
#
#Vamos a considerar ahora el archivo archivoClientesEntrega.csv.
#
#Crea el código para leer los datos del archivo y generar un archivo csv con 
#los siguientes encabezados  
#       Clientes
#       Numero de Camiones
