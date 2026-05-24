from pessoa import Pessoa

class Professor(Pessoa):
    def __init__(self, nome, salario):
        super().__init__(nome)
        self.salario = salario

    def __repr__(self):
        return f"Professor: {self.nome} | Salário: R$ {self.salario:.2f}"