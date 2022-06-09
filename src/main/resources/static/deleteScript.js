let id = NaN

function setId(idNew){
    id = idNew;
}

function deletePatient(){
    document.location.href='deletePatient/' + id
}