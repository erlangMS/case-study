#!/usr/bin/python
# -*- coding: utf-8 -*-

from fpc.forms import FpcCrud, FpcForm

from sae.models import ValorAlimentacao, Ocorrencias, ImprimeAgendamento, Campus


# Cadastros básicos
class ValorAlimentacaoForm(FpcCrud):
    class Meta:
        model = ValorAlimentacao
        campos_pesquisa = ('campus', 'inicioVigencia', 'fimVigencia','pagaBeneficio', 'valorBeneficio')
        campos_grid_pesquisa = ('campus', 'inicioVigencia', 'fimVigencia','pagaBeneficio', 'valorBeneficio')
        layout = ('campus', 
                  ('inicioVigencia', 'fimVigencia'),
                  'valorBeneficio', 
                  'pagaBeneficio')
        layout_pesquisa = ('campus','inicioVigencia','fimVigencia','pagaBeneficio', 'valorBeneficio')
        titulo = "Valor Alimentação"


class CampusForm(FpcCrud):
    class Meta:
        model = Campus


class OcorrenciasForm(FpcCrud):
    class Meta:
        model = Ocorrencias
        campos_pesquisa = ('aluno_id', 'semestreAno', 'dataInicio',
                           'dataFim', 'suspendeBA')
        campos_grid_pesquisa = ('aluno_id', 'semestreAno', 'dataInicio'
                                , 'dataFim', 'suspendeBA')
        layout = ('id', 'aluno_id', 'semestreAno', 
                  ('dataInicio','dataFim'), 'suspendeBA'
                )
        layout_pesquisa = ('aluno_id', 'semestreAno', 'dataInicio',
                           'suspendeBA')
        titulo = "Ocorrências"



# ########### Estudo socioeconômico # ###########

class EstudoSocioEconomicoForm(FpcForm):
    class Meta:
        titulo = "Estudo Socioeconômico"
        template = 'estudo_socioeconomico.html'

class EstudoSocioEconomicoPreliminarForm(FpcForm):
    class Meta:
        titulo = "Estudo Socioeconômico Preliminar"
        template = 'estudo_socioeconomico/preliminar.html'

class ImprimeEstudoSocioEconomicoForm(FpcForm):
    class Meta:
        titulo = "Imprimir Estudo Estudo Socioeconômico"
        template = 'imprime_estudo_socioeconomico.html'


class InfoEstudoSocioEconomicoForm(FpcForm):
    class Meta:
        titulo = "Informações Sobre o Estudo Socioeconômico"
        template = 'info_estudo_socioeconomico.html'


# ########### Consultas / Relatórios ############


class ImprimeAgendamentoForm(FpcForm):
    class Meta:
        model = ImprimeAgendamento
        template = 'imprime_agendamento.html'
        titulo = 'Imprime Agendamento'
        layout = ('semestreAno', 'aluno_id', 'opcao')


