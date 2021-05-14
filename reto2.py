## Set welcome vars

sumtemp = 0.00
sumdepth = 0.00
measures = 0

flag = True

while flag:
    try: 
        measures = int(input("Provide the amount of measures taken into record: "))
        if measures > 0 :
            flag = False
    except:
        print("An integer number was expected. Please try again.")

category_label = ["No Apto", "Marginalmente Apto", "Moderadamente Apto", "Sumamente Apto"]
category_count = [0,0,0,0]

for count in range(measures):
    print(f'Reading now Measure #{count+1}')
    temp = 0.0
    depth = 0.0
    while True:
        try: 
            temp = float(input("Provide average terrain temperature: "))
            depth = float(input("Provide efective soil depth: "))
            break
        except:
            print("A decimal number was expected. Please try again.")

    sumtemp+=temp
    sumdepth+=depth

    category_temp = 0
    category_depth = 0

    ## Temperature
    if (temp < 18)  or (temp > 32):
        category_temp = 0
    elif (temp < 21) or (temp in range(31,33)):
        category_temp = 1
    elif temp < 25 or (temp in range(29,31)):
        category_temp = 2
    else:
        category_temp = 3

    ## Depth
    if depth <25:
        category_depth = 0
    elif depth < 50:
        category_depth = 1
    elif depth < 101:
        category_depth = 2
    else:
        category_depth = 3

    category_count[min(category_temp,category_depth)] = category_count[min(category_temp,category_depth)]+1

print(f'{round(sumtemp/measures,2)}')
print(f'{round(sumdepth/measures,2)}')

category_label.reverse()
category_count.reverse()

for index in range(len(category_label)):
    print(f'{category_label[index]} {category_count[index]}')