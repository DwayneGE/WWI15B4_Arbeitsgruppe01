import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});


//Handling für alle möglichen Routes die unsere Webanwendnung aufrufen kann
Router.map(function() {
  this.route('buch', function() {
    this.route('bearbeiten');
    this.route('anlegen');
    this.route('ändern', {path:'aendern/:buchid'});
  });
  
});

export default Router;
