from pessoa import Pessoa

class Aluno(Pessoa):

    def _init__(self, nome):
        super().__init__(nome)
        self.notas = []

    def incluirNota(self, nota):
        self.notas.append(nota)

    def calcularMedia(self):
        media = 0.0
        for nota in self.notas:
            media += nota
        return media/len(self.notas)
    
    def __repr__(self):
        return 'Nome Aluno {} - Média: {}'.format(self.nome, self.calcularMedia())
        

