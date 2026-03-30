class Visitante:

    def __init__(self):
        self.nome = ''
        self.sobrenome = ''
        self.tempoNaBiblioteca = 0

    def __str__(self):
        return "Visitante: {} {} | Tempo: {} minutos".format(self.nome, self.sobrenome, self.tempoNaBiblioteca)