<?php

/**
 * File to handle all API requests
 * Accepts GET and POST
 * 
 * Each request will be identified by TAG
 * Response will be JSON data

  /**
 * check for POST request 
 */
if (isset($_POST['tag']) && $_POST['tag'] != '') {
	
	// response Array
    $response = array("tag" => $tag, "success" => 1, "error" => 0);
    $response["respuesta"] = "Asuncion";
    echo json_encode($response);

} else {		
	    echo "Access Denied: ".$_POST['tag']." - ".isset($_POST['tag']);
}
?>
