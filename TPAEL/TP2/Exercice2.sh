#!/bin/bash

valeurAttribut="\"&?[^<,\",>]*\"";
nomXML="[[:alpha:]_:][[:alnum:]:_-.]*";
refEntite="&$nomXML;";
baliseOuvrante="<$nomXML \s$nomXML\s?=\s?$valeurAttribut*\s?>";

#echo $baliseOuvrante
#egrep --color=auto $valeurAttribut html/*
egrep --color=auto $baliseOuvrante html/*

#Q3 
egrep --color '(\+[[:digit:]]{2}[[:space:]]\(0\)[[:space:]][[:digit:]](.[[:digit:]]{2}){4})|(.[[:digit:]]{2}){5}' html/*.html
