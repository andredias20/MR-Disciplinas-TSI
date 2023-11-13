import json

def jsonFileWritter(file_name:str, data:any):
    with open(file_name, 'w', encoding='utf-8') as file:
        json.dump(data, file, ensure_ascii=False, indent=4)

