import csv, os.path

def se_programa(presion_sistolica, presion_diastolica) -> bool:
    se_programa = False
    if presion_sistolica < 91 and presion_diastolica < 63:
        se_programa= True
    elif 162 <= presion_sistolica < 188 and 105 <= presion_diastolica < 119:
        se_programa= True
    elif 188 <= presion_sistolica < 201 and 119 <= presion_diastolica < 126:
        se_programa= True
    elif 201 <= presion_sistolica < 214 and 126 <= presion_diastolica < 146:
        se_programa= True
    elif presion_sistolica >= 214 and presion_diastolica >= 146:
        se_programa= True
    elif presion_sistolica >= 152 and presion_diastolica < 77:
        se_programa= True
    else:
        se_programa=False

    return se_programa

sucursal = input("")
ubicacion_sucursal = ""
cantidad_mujeres = 0
cantidad_hombres = 0
cantidad_pacientes_programados = 0
suma_medicamentos_programados = 0

with open(os.path.join(os.path.dirname(os.path.abspath(__file__)),'data.csv'), encoding='utf-8') as archivo_datos:
    lector = csv.reader(archivo_datos, delimiter=',')
    linea = 0
    for fila in lector:
        if linea != 0: ## Avoid headers
            if fila[5]==sucursal:
                if ubicacion_sucursal == "":
                    ubicacion_sucursal = fila[3]+" "+fila[4]
                if se_programa(int(fila[8]), int(fila[9])):
                    cantidad_pacientes_programados+=1
                    suma_medicamentos_programados+=int(fila[7])
                    if fila[2] == "f":
                        cantidad_mujeres+=1
                    else:
                        cantidad_hombres+=1
        linea += 1

print(sucursal, ubicacion_sucursal)
print("scheduled patients")
print("male", cantidad_hombres)
print("female", cantidad_mujeres)
print("total", cantidad_pacientes_programados)
print("scheduled medicine quantity")
print("mean", format(suma_medicamentos_programados/cantidad_pacientes_programados,".2f"))
print("total", suma_medicamentos_programados)