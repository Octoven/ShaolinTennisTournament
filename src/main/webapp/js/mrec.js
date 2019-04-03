$("#record").click(
		function() {

			if ($("#datepicker").val() == "") {
				alert("Veuillez spécifier une date.");
				return false;
			}

			else if ($("#j1").val() == $("#j2").val()) {
				$('#warning').text(
						"Un joueur ne peut pas concourir contre lui-même !");
				return false;
			}
			
			return true;

		});