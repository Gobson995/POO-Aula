class Carro:

    def __init__(self):
        self.placa = ''
        self.cor = ''
        self.marca = ''
        self.velocidade = 0

    def acelerar(self, velocidade: int = 10):
        self.velocidade += velocidade   