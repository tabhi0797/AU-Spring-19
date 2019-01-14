import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import EditIcon from '@material-ui/icons/Edit';
import Switch from '@material-ui/core/Switch';
import FoodFormDialog from './FoodItemForm';

const styles = {
  root: {
    width: '100%',
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
};

let id = 0;
function createData(itemname, price, isavailable = true) {
  id += 1;
  return { id, itemname, price, isavailable };
}

const data = [
  createData('Sambar', 20, true),
  createData('Dal', 20, true),
  createData('Curd', 10, true),
  createData('Tamato Curry', 25, false),
];



class SimpleTable extends React.Component {

  constructor(){
    super();
    this.state = {data:data};
  }

  editOnClick(id) {
    console.log(id);
  }


  addRowOnClick = function(itemname, price, isavailable){
    // this.setState({data:{abc:'abc'}});
    data.push(createData(itemname,price,isavailable))
    console.log(data);
    this.setState({temp:'temp'});
  }.bind(this);

  render() {

    const { classes } = this.props;

    return (
      <div className="centerpage">
        <Paper className={classes.root}>
          <div align='right'>
            <FoodFormDialog setState={this.setState} addRow = {this.addRowOnClick}/>
          </div><br />
          <Table className={classes.table}>
            <TableHead style={{ backgroundColor: '#000000' }}>
              <TableRow>
                <TableCell style={{ color: '#ffffff' }} align="right">Item Name</TableCell>
                <TableCell style={{ color: '#ffffff' }} align="right">Price</TableCell>
                <TableCell style={{ color: '#ffffff' }} align="right">Is Available?</TableCell>
                <TableCell style={{ color: '#ffffff' }} align="right">Edit</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data.map(n => {
                return (
                  <TableRow key={n.id}>
                    <TableCell align="right">{n.itemname}</TableCell>
                    <TableCell align="right">{n.price}</TableCell>
                    <TableCell align="right"><Switch checked={n.isavailable}></Switch></TableCell>
                    <TableCell align="right"><EditIcon id={n.id} onClick={() => this.editOnClick(n.id)} /></TableCell>
                  </TableRow>
                );
              })}
            </TableBody>
          </Table>
        </Paper>
      </div>
    );
  }
}

SimpleTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SimpleTable);