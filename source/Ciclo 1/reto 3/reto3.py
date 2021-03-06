# Helpers

def validate_input(message, expected_type=0):
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

def validate_series(value_list):
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

def cast_list(test_list, data_type):
    return list(map(data_type, test_list))


## Main Loop

zones = validate_input("")
category_label = ["No Apto", "Marginalmente Apto", "Moderadamente Apto", "Sumamente Apto"]
category_count = [0,0,0,0]

avg_temps = ""
avg_depths = ""
for i in range(zones):
    ##print(f"Zone {i+1}")
    switch = True
    temp_array = ''
    depth_array = ''
    while switch:
        temp_array = input("")
        depth_array= input("")
        switch = (not validate_series(temp_array)) and (not validate_series(depth_array))
    temps = cast_list(temp_array.split(), float)
    depths = cast_list(depth_array.split(), float)
    item_temp = round(sum(temps)/len(temps),2)
    item_depth = round(sum(depths)/len(depths),2)
    avg_temps += format(item_temp, '.2f')+" "
    avg_depths+= format(item_depth, '.2f')+" "

    category_temp = 0
    category_depth = 0

    ## Temperature
    if (item_temp < 18)  or (item_temp > 32):
        category_temp = 0
    elif (18 <= item_temp <= 20) or (30 < item_temp <= 32):
        category_temp = 1
    elif (20 < item_temp <= 24) or (28 < item_temp <= 30):
        category_temp = 2
    else:
        category_temp = 3

    ## Depth
    if item_depth <25:
        category_depth = 0
    elif (25 <= item_depth <= 50):
        category_depth = 1
    elif (50 < item_depth <= 100):
        category_depth = 2
    else:
        category_depth = 3

    category_count[min(category_temp,category_depth)] = category_count[min(category_temp,category_depth)]+1

print(avg_temps.rstrip())
print(avg_depths.rstrip())

category_label.reverse()
category_count.reverse()

for index in range(len(category_label)):
    print(f'{category_label[index].lower()} {category_count[index]}')