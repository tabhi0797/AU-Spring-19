import React, { Component } from 'react';
import './App.css';
import Dashboard from './Dashboard';
import { BrowserRouter as Switch, Route } from 'react-router-dom';
import OrderList from './OrderList';
import SimpleTable from './SimpleTable';
import { withRouter } from 'react-router';

class App extends Component {
  render() {
    return (
        <div className="App">
          <Dashboard></Dashboard>
          <Route exact path="/" component={withRouter(Dashboard)} />
          <Route exact path='/home' component={withRouter(SimpleTable)} />
          <Route exact path='/order' component={withRouter(OrderList)} />
        </div>
    );
  }
}

export default App;
