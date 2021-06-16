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
category_label = ["no apto", "marginalmente apto", "moderadamente apto", "sumamente apto"]
category_count = [0,0,0,0]

temps = []
depths = []
counts = []

for i in range(zones):
    temp_reading = input("")
    zone_temps = cast_list(temp_reading.split(), float)
    temps.append(zone_temps)

for i in range(zones):
    depth_reading = input("")
    zone_depths = cast_list(depth_reading.split(), float)
    depths.append(zone_depths)
    category_row_count = [0,0,0,0]

    for j in range(len(zone_depths)):
        category_temp = 0
        category_depth = 0
        
        ## Temperature
        if (temps[i][j] < 18)  or (temps[i][j] > 32):
            category_temp = 0
        elif (temps[i][j] < 21) or (temps[i][j] in range(31,33)):
            category_temp = 1
        elif temps[i][j] < 25 or (temps[i][j] in range(29,31)):
            category_temp = 2
        else:
            category_temp = 3

        ## Depth
        if depths[i][j] <25:
            category_depth = 0
        elif depths[i][j] < 51:
            category_depth = 1
        elif depths[i][j] < 101:
            category_depth = 2
        else:
            category_depth = 3

        category_count[min(category_temp,category_depth)] = category_count[min(category_temp,category_depth)]+1
        category_row_count[min(category_temp,category_depth)] = category_row_count[min(category_temp,category_depth)]+1
    counts.append(category_row_count)

first_result = ""
for k in range(len(category_count)):
    first_result+=str(category_count[k])+" "

print(first_result.rstrip())

category_label.reverse()

second_result = ""
third_result = ""
    
for zone in range(zones):
    row_list = list(counts[zone]).copy()[::-1]
    ## Consider zero.
    #item_tosearch = min(row_list)
    ## Don't consider zero
    
    item_tosearch = max(row_list)
    for i in range(len(row_list)):
        if row_list[i]>0 and row_list[i]<item_tosearch:
            item_tosearch = row_list[i]
    
    second_result+= category_label[(row_list).index(item_tosearch)]+","
    third_result+= category_label[(row_list).index(max(row_list))]+","

print(third_result.rstrip(","))
print(second_result.rstrip(","))