class Colaborador:

    def __init__(self):
        self.nome = ''
        self.idade = 0
        self.setor = ''

    def __str__(self):
        return "Colaborador: {} tem {} anos. Atua no setor: {}".format(self.nome, self.idade, self.setor)
    
