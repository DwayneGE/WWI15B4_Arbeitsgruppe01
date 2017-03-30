import Ember from 'ember';

export default Ember.Controller.extend({
    actions:{
        save(buchRecord){
            console.log(buchRecord);
            buchRecord.save()
            .then(()=> console.log('erfolg'))
            .catch(()=>console.log('ein fehler'));
            this.transitionToRoute("buch.bearbeiten");
        }
    }
});
