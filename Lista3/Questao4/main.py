from aluno import Aluno
from professor import Professor

prof1 = Professor("Fabiano Baldo", 8500.00)
prof2 = Professor("Ana Silva", 7200.00)

aluno1 = Aluno("Gustavo")
aluno1.incluirNota(8.5)
aluno1.incluirNota(9.0)

aluno2 = Aluno("Maria")
aluno2.incluirNota(6.0)
aluno2.incluirNota(5.5)

aluno3 = Aluno("João")
aluno3.incluirNota(7.5)
aluno3.incluirNota(8.0)

aluno4 = Aluno("Pedro")
aluno4.incluirNota(4.0)
aluno4.incluirNota(6.0)

aluno5 = Aluno("Laura")
aluno5.incluirNota(10.0)
aluno5.incluirNota(9.5)

print("=== PROFESSORES ===")
print(prof1)
print(prof2)

print("\n=== ALUNOS ===")
print(aluno1)
print(aluno2)
print(aluno3)
print(aluno4)
print(aluno5)