# -*- coding: UTF-8 -*-
from fpc.forms import FpcForm, FpcOperacaoForm
from fpc.views import fpc_request, FpcJsonMessage


@fpc_request    
def estudo_socioeconomico(request):    
    ts = request.ts
    form = FpcForm.get_form(request)
    template = form.createTemplate(FpcOperacaoForm.novo)
    response = FpcJsonMessage("", "info", {"template" : template, 
                                           "ts" : ts.pk })
    return response





        

