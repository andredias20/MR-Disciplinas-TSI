import requests
from Indicador import DadosTaxa

URL = "http://servicodados.ibge.gov.br/api/v1/paises/BR%7CRU%7CIN%7CCN%7CZA/indicadores/77844"
data = requests.get(URL).json()

paises = data[0]['series']

DadosTaxas = list()

for pais in paises:
    nome = pais['pais']['nome']

    for i in pais['serie']:
        dados = dict(i)
        key = list(dados.keys())[0]
        value = list(dados.values())[0]
        if value:
            DadosTaxas.append(DadosTaxa(nome, key, value))

ordenadas = sorted(DadosTaxas, key=lambda x: x.taxa, reverse=True)

print("------- TOP 10 TAXAS --------")
for i in range(0, 9):
    print(ordenadas[i])

print('Programa finalizado!')
