temp = 0.0
depth = 0.0

while True:
    try: 
        temp = float(input("Provide average terrain temperature: "))
        depth = float(input("Provide efective soil depth: "))
        break
    except:
        print("A decimal number was expected. Please try again.")

category_label = ["No Apto", "Marginalmente Apto", "Moderadamente Apto", "Sumamente Apto"]
category_temp = 1
category_depth = 1

## Temperature
if (temp < 18)  or (temp > 32):
    category_temp = 1
elif (temp < 21) or (temp in range(31,33)):
    category_temp = 2
elif temp < 25 or (temp in range(29,31)):
    category_temp = 3
else:
    category_temp = 4

## Depth
if depth <25:
    category_depth = 1 
elif depth < 50:
    category_depth = 2
elif depth < 101:
    category_depth = 3
else:
    category_depth = 4

print(category_label[min(category_temp,category_depth)-1])