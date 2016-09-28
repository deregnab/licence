#!/bin/bash

valeurAttribut="\"&?[^<,\",>]*\"";
nomXML="[[:alpha:]_:][[:alnum:]:_-.]*";
refEntite="&$nomXML;";
baliseOuvrante="<$nomXML \s$nomXML\s?=\s?$valeurAttribut*\s?>";

#echo $baliseOuvrante
#egrep --color=auto $valeurAttribut html/*
egrep --color=auto $baliseOuvrante html/*
