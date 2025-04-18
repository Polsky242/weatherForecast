{{- define "weatherForecast.labels" -}}
app.kubernetes.io/name: {{ .Chart.Name }}
app.kubernetes.io/instance: {{ .Release.Name }}
environment: {{ .Values.env | quote }}
{{- end }}