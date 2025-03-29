# ClinicaApi
<h1> APi de estudo simulando uma clinica bem basico</h1>
<p>TEM validacoes Nos PUT/POST, se botarem info invalidas, ira devolver um erro  e um json no corpo com o motivo</p>
<p> OBS NO aplicattion.properties-> mudem o banco de dados, usuario e senha para o que voces usam</p>
<p> tem o swagger para documentaçao e no CORS eu deixei como 8080 a porta do swagger, se mudarem a porta no banco, mudem NO CORS TBM! ou usem pelo localhost:8080/ mesmo</p>
<h3>Controller medico</h3>
<ul><li> POST localhost:8080/medico -> cadastar o medico no banco de dados, a partir do json no crpo da requisição<br>
{
  "firstName": "",
  "lastName": "",
  "especialidade": "",
  "adress": {
    "cidade": "",
    "bairro": "",
    "estado": ""
  },
  "email": "string",
  "crm": "7738"
}
</li>
  <li>PUT localhost:8080/medico/id -> atualiza a informaçao de um medico no banco de dados, deve ter um json no corpo da requisiçao;
    {
  "email": "string",
  "adressDTO": {
    "cidade": "",
    "bairro": "",
    "estado": ""
  }
}
  <li> GET localhost:8080/medico/id -> traz o cadastro do medico de um id especifico</li>
  <li> GET localhost:8080/medico/lista -> traz a lista de todos os mecidos no banco de dados</li>
  <li>GET localhost:8080/medico/listabusca?especialidade= -> trz uma lista de medicos por uma das especialidades</li>
</ul>

<h3>Controller Paciente</h3>
<ul><li>POST  localhost:8080/paciente ->cadastra o paciente no banco de dados, a partir do json no corpo do request:<br>
{
  "firstName": "",
  "lastName": "",
  "email": "",
  "cpf": ""
}</li>
  <li> GET localhost:8080/paciente/id -> traz a info de uma paciente especifico do banco </li>
  <li>  GET localhost:8080/medico/lista -> traz a lista de todos os pacientes no banco de dados</li>
</ul>

<h3>COntroller Consulta</h3>
<ul><li>POST  localhost:8080/consulta -> cadastra uma consulta no banco, só pode ter 1 consulta por dia, tanto pro medico ou paciente<br>
{
  "pacienteId": ,
  "medicoId":,
  "data": ""
}</li>
  <li> GET localhost:8080/consulta/lista/paciente/id -> traz a info da consulta pelo id do paciente</li>
   <li> GET localhost:8080/consulta/lista/paciente/id -> traz a uma lista de consulta pelo id do paciente</li>
   <li> GET localhost:8080/consulta/lista/medico/id -> traz a uma lista de consulta pelo id do medico</li>
   <li> PUT localhost:8080/consulta/remarcar/pacienteid -> remarcar a data da consulta para uma nova, seginto o criterio que tanto o paciente e medico só podem ter 1 consulta por dia<br>
     {
  "novaData": "string",
  "dataAntiga": "string"
}
   </li>
  
</ul>
