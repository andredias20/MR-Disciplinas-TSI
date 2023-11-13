arquivo = open("8332.xml")


# Parte 1 --------------------------------
count = 0
for linha in arquivo:
    if linha.__contains__("<title>"): count+=1

print("O arquivo tem registro de",count,"publicações")

# Parte 2 --------------------------------

import xml.etree.ElementTree as et

tree = et.parse('8332.xml')
root = tree.getroot()

coauthors = root.find('coauthors')

print('\nConjunto de co-autores: ')
for co in coauthors:
    print(co[0].text)

# Parte 3 --------------------------------  

print('\nConjunto de veiculos de publicação: ')
for pubs in root.findall('r'):
    journal = pubs[0].find('journal')
    booktitle = pubs[0].find('booktitle')
    if journal is not None:
        print(journal.text)
    else:
        print(booktitle.text)
