from pessoa import Pessoa

class Aluno(Pessoa):
    def __init__(self, nome):
        super().__init__(nome)
        self.notas = []

    def incluirNota(self, nota):
        self.notas.append(nota)

    def calcularMedia(self):
        if len(self.notas) == 0:
            return 0.0
        
        return sum(self.notas)/len(self.notas)
    
    def __repr__(self):
        media = self.calcularMedia()
        status = "Aprovado" if media > 7.0 else "Em Exame"

        return f"Aluno: {self.nome} | Notas: {self.notas} | Média: {media:.2f} | Status: {status}"      

