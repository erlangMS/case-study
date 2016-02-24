# -*- coding: utf-8 -*-
from django.apps.config import AppConfig
from fpc.models import Transacao
import sys


class SaeWebConfig(AppConfig):
    name = 'saeweb'
    label = "saeweb"
    verbose_name = "saeweb"
    
    def ready(self):
        
        print("Iniciando deploy do saeweb, aguarde...")
        self.cadastra_transacoes()
            
        
    def cadastra_transacoes(self):
        if not ("syncdb" in sys.argv or "evolve" in sys.argv) :
            ###################################### Módulo SAE ######################################
    
            # Sistema SAE
            ts = Transacao()
            ts.nome = 'saeweb'
            ts.titulo = 'Assistência Estudantil'
            ts.tipoTransacao = 'S'
            ts.posicao = 2
            ts.image_url = 'class glyphicon glyphicon-folder-close'
            ts.formModel = 'fpc.forms.SistemaForm'
            try:
                ts.save()
            except:
                pass;
    
    
            # menu Cadastros
            ts = Transacao()
            ts.nome = 'saeweb/cadastro'
            ts.titulo = 'Cadastro'
            ts.tipoTransacao = 'F'
            ts.posicao = 1
            ts.formModel = 'fpc.forms.PainelForm'
            ts.image_url = 'class glyphicon glyphicon-list-alt'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb')
            try:
                ts.save()
            except:
                pass;
    
    
            # menu Vale Alimentação
            ts = Transacao()
            ts.nome = 'saeweb/cadastro/valor_alimentacao'
            ts.titulo = 'Valor Alimentação'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/fpc.views.fpc_exibe_pesquisa'
            ts.posicao = 1
            ts.formModel = 'sae.forms.ValorAlimentacaoForm'
            ts.model = 'sae.models.ValorAlimentacao'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/cadastro')
            try:
                ts.save()
            except:
                pass;
    

            # menu Auxílio Alimentação
            ts = Transacao()
            ts.nome = 'saeweb/cadastro/auxilio_alimentacao.html'
            ts.titulo = 'Auxílio Alimentação'
            ts.pageController = 'auxilio-alimentacao-controller'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/cadastro')
            try:
                ts.save()
            except:
                pass;
    
            # menu Ocorrências
            ts = Transacao()
            ts.nome = 'saeweb/cadastro/ocorrencia'
            ts.titulo = 'Ocorrências'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/fpc.views.fpc_exibe_pesquisa'
            ts.posicao = 1
            ts.formModel = 'sae.forms.OcorrenciasForm'
            ts.model = 'sae.models.Ocorrencias'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/cadastro')
            try:
                ts.save()
            except:
                pass;
    
    
            
    
            # menu Consultas/Relatórios
            ts = Transacao()
            ts.nome = 'saeweb/consultas'
            ts.titulo = 'Consultas/Relatórios'
            ts.tipoTransacao = 'F'
            ts.posicao = 1
            ts.formModel = 'fpc.forms.PainelForm'
            ts.image_url = 'class glyphicon glyphicon-list-alt'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb')
            try:
                ts.save()
            except:
                pass;
    
    
            # menu Imprimir Agendamento
            ts = Transacao()
            ts.nome = 'cad_imprime_agendamento_sae'
            ts.titulo = 'Imprime Agendamento'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/fpc.views.fpc_exibe_pesquisa'
            ts.posicao = 1
            ts.formModel = 'sae.forms.ImprimeAgendamentoForm'
            ts.model = 'sae.models.ImprimeAgendamento'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/consultas')
            try:
                ts.save()
            except:
                pass;
            
            # menu Estudo socioeconomico
            ts = Transacao()
            ts.nome = 'saeweb/estudo_socioeconomico'
            ts.titulo = 'Estudo Socioeconômico'
            ts.tipoTransacao = 'F'
            ts.posicao = 1
            ts.formModel = 'fpc.forms.PainelForm'
            ts.image_url = 'class glyphicon glyphicon-list-alt'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb')
            try:
                ts.save()
            except:
                pass;
            
            # Preencher formulário do estudo socioeconômico preliminar
            ts = Transacao()
            ts.nome = 'saeweb/estudo_socioeconomico/preliminar'
            ts.titulo = 'Preencher Formulário'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/sae/estudosocioeconomico'
            ts.posicao = 1
            ts.formModel = 'sae.forms.EstudoSocioEconomicoForm'
            ts.model = 'sae.models.EstudoSocioEconomico'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/estudo_socioeconomico')
            try:
                ts.save()
            except:
                pass;
    
    
            # Imprimir formulário do estudo socioeconômico
            ts = Transacao()
            ts.nome = 'saeweb/estudo_socioeconomico/imprimir'
            ts.titulo = 'Imprimir Formulário'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/fpc.views.fpc_exibe_pesquisa'
            ts.posicao = 2
            ts.formModel = 'sae.forms.ImprimirEstudoSocioEconomicoForm'
            ts.model = 'sae.models.EstudoSocioEconomico'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/estudo_socioeconomico')
            try:
                ts.save()
            except:
                pass;
    
    
            # Preencher formulário do estudo socioeconômico
            ts = Transacao()
            ts.nome = 'saeweb/estudo_socioeconomico/info'
            ts.titulo = 'Informações Sobre o Estudo'
            ts.tipoTransacao = 'T'
            ts.transacao_url = '/fpc.views.fpc_exibe_pesquisa'
            ts.posicao = 3
            ts.formModel = 'sae.forms.InfoEstudoSocioEconomicoForm'
            ts.image_url = 'class glyphicon glyphicon glyphicon-asterisk'
            ts.transacaoPai = Transacao.objects.get(nome='saeweb/estudo_socioeconomico')
            try:
                ts.save()
            except:
                pass;
        
    
    
