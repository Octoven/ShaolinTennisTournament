$("#rec").click(function(){
	

	if (pseudo.value=='') { 
		$('#war1').text("Veuillez entrer votre identifiant.");
	}
	
});


$('#erase').click(function() {
    
    $('#pseudo').val("");
    $('#psswd').val("");
    
});
