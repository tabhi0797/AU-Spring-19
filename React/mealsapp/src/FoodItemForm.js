import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import AddIcon from '@material-ui/icons/Add';
import Fab from '@material-ui/core/Fab';
import Switch from '@material-ui/core/Switch';

export default class FoodFormDialog extends React.Component {
  state = {
    open: false,
  };

  handleClickOpen = () => {
    this.setState({ open: true });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  submitClicked = () => {
    this.props.addRow(this.state.itemname, this.state.price, this.state.isavailable);
    this.setState({ open: false });
  }

  render() {
    return (
      <div>
        <Fab color="primary" aria-label="Add" >
            <AddIcon onClick={this.handleClickOpen}/>
        </Fab>
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">New Item</DialogTitle>
          <DialogContent>
            <TextField
              autoFocus
              margin="dense"
              id="itemname"
              label="Item Name"
              type="text"
              onChange ={(text) => this.setState({itemname: text.target.value})}
              fullWidth
            />
            <TextField
              autoFocus
              margin="dense"
              id="price"
              label="Price(in Rs)"
              type="number"
              onChange ={(text) => this.setState({price: text.target.value})}
              fullWidth
            />
            <DialogContentText>
                Is Available? 
                <Switch id = "isavailable" onChange={(state) => this.setState({isavailable:state.target.autofocus})}></Switch>
            </DialogContentText>
            
          </DialogContent>
          <DialogActions>
            <Button onClick={() => this.submitClicked()} color="primary">
              Submit
            </Button>
            <Button onClick={this.handleClear} color="primary">
              Clear
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}