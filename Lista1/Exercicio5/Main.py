from Classes.Visitante import Visitante
from Classes.Colaborador import Colaborador

v1 = Visitante()
v1.nome = "Neymar"
v1.sobrenome = "Junior"
v1.tempoNaBiblioteca = 10

v2 = Visitante() 
v2.nome = "Jaquelini"
v2.sobrenome = "Bada"
v2.tempoNaBiblioteca = 5

print(v1)
print(v2)

print("\n\n\n")

c1 = Colaborador()
c1.nome = "Roberto"
c1.idade = 42
c1.setor = "Acervo Geral"

c2 = Colaborador()
c2.nome = "Fernanda"
c2.idade = 26
c2.setor = "Atendimento ao Publico"

print(c1)
print(c2)