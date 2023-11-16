class Pessoa:
    def __init__(self, nome, dataNasc, cpf):
        self.nome = nome
        self.dataNasc = dataNasc
        self.cpf = cpf

pessoas = list()

pessoas.append(Pessoa('André', '04/05/2000', '000.000.000-00'))
pessoas.append(Pessoa('Mario', '05/05/2000', '000.000.000-01'))
pessoas.append(Pessoa('Luigi', '06/05/2000', '000.000.000-02'))

import xml.etree.ElementTree as et

root = et.Element('objetos')

for pessoa in pessoas:
    p_element = et.SubElement(root, pessoa.__class__.__name__)
    for campo in pessoa.__dict__.keys():
        c_element = et.SubElement(p_element, campo)
        c_element.text = getattr(pessoa, campo)

tree = et.ElementTree(root)
tree.write("pessoas.xml")