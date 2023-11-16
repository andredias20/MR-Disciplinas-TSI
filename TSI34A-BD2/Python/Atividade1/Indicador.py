class DadosTaxa:
    def __init__(self, idPais: str, ano: str, taxa: float):
        self.idPais = idPais
        self.ano = ano
        self.taxa = taxa
    
    def __str__(self):
        value = "Pais: " + self.idPais + " Ano: "+ self.ano +" Taxa: " + self.taxa
        return value