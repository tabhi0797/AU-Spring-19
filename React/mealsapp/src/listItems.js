import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import HomeIcon from '@material-ui/icons/Home';
import LayersIcon from '@material-ui/icons/Layers';
import AssignmentIcon from '@material-ui/icons/Assignment';
import { BrowserRouter as Router, Link } from 'react-router-dom';



export const mainListItems = (
  <Router>
    <div>
      <ListItem button>
        <ListItemIcon>
          <a href='/home'><HomeIcon /></a>
        </ListItemIcon>
        <ListItemText primary="Home" />
      </ListItem>

      <ListItem button>
        <ListItemIcon>
          <a href='/order'>
            <LayersIcon />
          </a>
        </ListItemIcon>
        <ListItemText primary="Orders" />
      </ListItem>
    </div>
  </Router>
);

export const secondaryListItems = (
  <div>
    <ListSubheader inset>Admin Portal</ListSubheader>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="Orders" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="Food Items" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="Year-end sale" />
    </ListItem>
  </div>
);