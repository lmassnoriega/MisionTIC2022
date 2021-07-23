# Helpers
import csv, os

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

zone = input("")

## To do: Convert these two list into a Dictionary.
category_label = ["no apto", "marginalmente apto", "moderadamente apto", "sumamente apto"]
category_count = [0,0,0,0]
##
temp_sum = 0.0
depth_sum = 0.0
min_temp = float('inf')
max_temp = 0.0
min_depth = float('inf')
max_depth = 0.0
zone_count = 0

with open('data.csv', encoding='utf-8') as data_file:
    reader = csv.reader(data_file, delimiter=',')
    line_count = 0
    for row in reader:
        if line_count != 0: ## Avoid headers
            if row[0]==zone:
                temp_sum+= float(row[3])
                depth_sum+= float(row[5])
                zone_count+=1
                
                ## Lookup maxs and mins.
                if float(row[3])<min_temp:
                    min_temp = float(row[3])
                if float(row[3])>max_temp:
                    max_temp = float(row[3])
                if float(row[5])<min_depth:
                    min_depth = float(row[5])
                if float(row[5])>max_depth:
                    max_depth = float(row[5])
                
                ## Count categories
                category_count[category_label.index(str(row[6]).lower())]+=1

        line_count += 1

print(format(temp_sum/zone_count, '.2f')+" "+format(depth_sum/zone_count, '.2f'))
print(f'{int(min_temp)} {int(min_depth)}')
print(f'{int(max_temp)} {int(max_depth)}')

## To do: Sort dictionary by two keys.
for i in range(len(category_label)):
    print(f'{category_label[i]} {category_count[i]}')