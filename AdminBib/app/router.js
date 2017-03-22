import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('bearbeiten');
  this.route('anlegen');
  this.route('ändern', {path:'aendern/:buchid'});
});

export default Router;
