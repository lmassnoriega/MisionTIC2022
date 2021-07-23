import numpy as np

def validar_entrada(message, expected_type=0):
    returned_value = 0.0
    if expected_type == 0:
        while True:
            try:
                returned_value = int(input(message))
                break
            except:
                print("Expected integer value, try again")
    else:
        while True:
            try:
                returned_value = float(input(message))
                break
            except:
                print("Expected decimal value, try again")
    return returned_value

def validar_serie(value_list):
    values = value_list.split()
    new_list = []
    flag = True
    for value in values:
        try:
            new_list.append(float(value))
        except:
            flag = False
            break
    return flag

def convertir_lista(test_list, data_type):
    return list(map(data_type, test_list))

asignaciones = np.empty()
continuar_bandera = True

## Rellenar 

while continuar_bandera:
    lectura = input("Ingrese un nuevo registro de asignacion: \n")    
    asignacion = convertir_lista(lectura.split(), int)
    asignaciones = np.concatenate(asignaciones, asignacion, axis= 1)

    continuar = input("Desea continuar con mas asignaciones? Si/No")
    if continuar.lower() == "no":
        continuar_bandera = False
    
