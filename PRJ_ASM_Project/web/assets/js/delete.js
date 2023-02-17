/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function Alert(id) {
    var option = confirm("Do you really want to delete ?");
    if (option === true) {
        window.location.href = 'khoa_delete?kid=' + id;
    }
}