import Ember from 'ember';

export default Ember.Controller.extend({

     actions: {
        //DELETE Request an die API mit der Buch ID des zu löschenden Buchs
        löschen: function(id) {
            this.get('store').findRecord('buch', id).then(function (buch) {
            buch.destroyRecord();
            }); 
        },
        //Methode zum Öffnen der Ändern Seite mit Übergabe der Buch ID des zu ändernden Buches
        ändernÖffnen: function (id) {
            this.transitionToRoute('buch.ändern', id );
        }
    }
});
