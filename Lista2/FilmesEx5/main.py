import json

texto_json = """
[
    {
        "titulo": "A Rainy Day in New York",
        "ano": 2019,
        "classificacao": "PG-13",
        "nota": 6.6
    },
    {
        "titulo": "Jurassic World: Fallen Kingdom",
        "ano": 2018,
        "classificacao": "PG-13",
        "nota": 6.2
    },
    {
        "titulo": "2001: A Space Odyssey",
        "ano": 1968,
        "classificacao": "G",
        "nota": 8.3
    },
    {
        "titulo": "Toy Story 4",
        "ano": 2019,
        "classificacao": "G",
        "nota": 7.8
    }
]
"""

class Filme:
    def __init__(self):
        self.titulo = ""
        self.ano = 0
        self.classificacao = ""
        self.nota = 0.0
    
    def carregar_do_json(self, pedaco_json):
        self.titulo = pedaco_json.get("titulo", "")
        self.ano = pedaco_json.get("ano", 0)
        self.classificacao = pedaco_json.get("classificacao", "")
        self.nota = pedaco_json.get("nota", 0.0)
    
    def __str__(self):
        return f"Nota: {self.nota} | Título: {self.titulo} ({self.ano}) - {self.classificacao}"

def pegar_nota(filme):
    return filme.nota

lista_dicionarios = json.loads(texto_json)

nossos_filmes = []

for dicionario in lista_dicionarios:
    novo_filme = Filme()
    novo_filme.carregar_do_json(dicionario)
    nossos_filmes.append(novo_filme)

nossos_filmes.sort(key=pegar_nota, reverse=True)

print("LISTA DE FILMES ORDENADA POR NOTA")

for filme in nossos_filmes:
    print(filme)