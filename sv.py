import json
import csv

# open JSON file
with open('F:/nitin/Nit1/src/main/scala/emp1.json', 'r') as f:
    data = json.load(f)

# open CSV file
with open('F:/nitin/Nit1/src/main/scala/emp11.csv', 'w', newline='') as f:
    writer = csv.writer(f)

    # write headers
    headers = list(data[0].keys())
    writer.writerow(headers)

    # write data
    for item in data:
        row = [str(item[h]) for h in headers]
        writer.writerow(row)

print("Conversion complete.")