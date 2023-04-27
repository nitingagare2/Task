import csv
import json
import mysql.connector

# Load the configuration file
with open('F:/Files/tasks/config.json') as f:
    config = json.load(f)

# Connect to the MySQL database
cnx = mysql.connector.connect(user=config['username'],
                              password=config['password'],
                              host=config['host'],
                              port=config['port'],
                              database=config['database'])

# Create a cursor
cursor = cnx.cursor()

# Create the target table
create_table_query = f"CREATE TABLE IF NOT EXISTS {config['target_table']} (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT)"
cursor.execute(create_table_query)

# Read the CSV file
with open(config['source_file'], 'r') as f:
    reader = csv.reader(f)
    next(reader)  # Skip the header row
    for row in reader:
        name, age = row
        # Insert the data into the MySQL table
        insert_query = f"INSERT INTO {config['target_table']} (name, age) VALUES (%s, %s)"
        cursor.execute(insert_query, (name, age))

# Commit the changes
cnx.commit()
print("data inserted successfully")

# Close the cursor and the database connection
cursor.close()
cnx.close()
