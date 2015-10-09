#!/usr/bin/python
# -*- coding: utf-8 -*-

from django.db import models
from fpc.models import FpcModel, FpcIntegerField, FpcDecimalField, EmsModel, \
    FpcTextField, FpcForeignKey


BOOLEAN = ((0, "Não"), (1, 'Sim'))
CAMPUS = ()

# CRUDS

class Campus(FpcModel):
    id = FpcIntegerField('Id', primary_key=True, auto_increment=True, editable=False, insertable=False)
    nome = FpcTextField('Nome', max_length=70, null=False, blank=False, unique=True, size=300, caixa_alta=False)


class ValorAlimentacao(EmsModel):
    service_url = "/sae/valoralimentacao"
    id = FpcIntegerField('Código', primary_key=True, auto_increment=True, editable=False, insertable=False, size=120)
    campus = FpcIntegerField('Campus', null=False, blank=False, choices=CAMPUS, render="combobox", lazy=True)
    inicioVigencia = models.DateField("Início Vigência", null=False, blank=False)
    fimVigencia = models.DateField('Fim Vigência?', null=True, blank=True)
    pagaBeneficio = FpcIntegerField('Paga Benefício?', null=False, blank=False, choices=BOOLEAN, render="radio", default="0")
    valorBeneficio = FpcDecimalField('Valor do Benefício', null=False, blank=False, default=0, max_digits=10, decimal_places=2)

class Ocorrencias(EmsModel):
    id = FpcIntegerField('Código', primary_key=True, auto_increment=True, editable=False, insertable=False, size=120)
    aluno_id = FpcIntegerField('Aluno', null=False, blank=False)
    semestreAno = FpcIntegerField('Semestre/Ano', null=True, blank=True)
    dataInicio = models.DateField("Data Início", null=True, blank=True)
    dataFim = models.DateField('Data Fim', null=True, blank=True)
    texto = FpcTextField('Texto', max_length=4000, null=True, blank=False, caixa_alta=False)
    suspendeBA = FpcIntegerField("Suspende Bolsa de Alimentação", size=160, null=False, blank=False, choices=BOOLEAN, default=0)



# Consultas / Relatórios

OPCAO_IMPRIME_AGENDAMENTO = ((0, 'Pedido Novo'), (1, "Renovação"))


class ImprimeAgendamento(FpcModel):

    id = FpcIntegerField('Código', primary_key=True, auto_increment=True, editable=False, insertable=False, size=120)
    semestreAno = FpcIntegerField('Semestre/Ano', null=True, blank=True)
    aluno_id = FpcIntegerField('Aluno', null=True, blank=True)
    opcao = FpcIntegerField("Opção", size=225, null=False, blank=False, choices=OPCAO_IMPRIME_AGENDAMENTO, default=0)

