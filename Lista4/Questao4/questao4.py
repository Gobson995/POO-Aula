class ObjetoSobrepostoException(Exception):
    def __init__(self, mensagem):
        super().__init__(mensagem)

class Ponto2D:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class Reta:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def intercepta(self, outra_reta):
        if self.a == outra_reta.a:
            return False
        return True

    def estaNaReta(self, ponto):
        if ponto.y == (self.a * ponto.x + self.b):
            return True
        return False

class EspacoGeometrico:
    def __init__(self):
        self.retas = []
        self.pontos = []

    def adicionarReta(self, reta):
        for r in self.retas:
            if reta.intercepta(r):
                raise ObjetoSobrepostoException("A nova reta intercepta uma reta ja existente.")
        self.retas.append(reta)

    def adicionarPonto(self, ponto):
        for r in self.retas:
            if r.estaNaReta(ponto):
                raise ObjetoSobrepostoException(f"O ponto ({ponto.x}, {ponto.y}) ja pertence a uma reta.")
        self.pontos.append(ponto)

if __name__ == "__main__":
    espaco = EspacoGeometrico()

    reta_vermelha = Reta(1, 2)
    reta_verde = Reta(1, 1)
    reta_azul = Reta(2, -2)

    try:
        espaco.adicionarReta(reta_vermelha)
        print("Reta vermelha (y = x + 2) adicionada.")
        
        espaco.adicionarReta(reta_verde)
        print("Reta verde (y = x + 1) adicionada.")
        
        espaco.adicionarReta(reta_azul)
        print("Reta azul (y = 2x - 2) adicionada.")
    except ObjetoSobrepostoException as e:
        print(f"ERRO DE RETA: {e}")

    pontoA = Ponto2D(3, 4)
    pontoB = Ponto2D(2, 3)
    pontoC = Ponto2D(4, 6)
    pontoD = Ponto2D(3, 2)

    pontos_teste = [("A", pontoA), ("B", pontoB), ("C", pontoC), ("D", pontoD)]

    for nome, ponto in pontos_teste:
        try:
            espaco.adicionarPonto(ponto)
            print(f"Ponto {nome} ({ponto.x}, {ponto.y}) adicionado ao espaco livre.")
        except ObjetoSobrepostoException as e:
            print(f"ERRO DE PONTO [{nome}]: {e}")