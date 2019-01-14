import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { withStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Badge from '@material-ui/core/Badge';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import LaunchIcon from '@material-ui/icons/Launch';
import { mainListItems, secondaryListItems } from './listItems';
import SimpleLineChart from './SimpleLineChart';
import SimpleTable from './SimpleTable';
import FoodFormDialog from './FoodItemForm';
import './App.css';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { post, get } from '../src/util/http.service';

const drawerWidth = 240;

const styles = theme => ({
    root: {
        display: 'flex',
    },
    toolbar: {
        paddingRight: 24, // keep right padding when drawer closed
    },
    toolbarIcon: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'flex-end',
        padding: '0 8px',
        ...theme.mixins.toolbar,
    },
    appBar: {
        zIndex: theme.zIndex.drawer + 1,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
    },
    appBarShift: {
        marginLeft: drawerWidth,
        width: `calc(100% - ${drawerWidth}px)`,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    menuButton: {
        marginLeft: 12,
        marginRight: 36,
    },
    menuButtonHidden: {
        display: 'none',
    },
    title: {
        flexGrow: 1,
    },
    drawerPaper: {
        position: 'relative',
        whiteSpace: 'nowrap',
        width: drawerWidth,
        transition: theme.transitions.create('width', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    },
    drawerPaperClose: {
        overflowX: 'hidden',
        transition: theme.transitions.create('width', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
        }),
        width: theme.spacing.unit * 7,
        [theme.breakpoints.up('sm')]: {
            width: theme.spacing.unit * 9,
        },
    },
    appBarSpacer: theme.mixins.toolbar,
    content: {
        flexGrow: 1,
        padding: theme.spacing.unit * 3,
        height: '100vh',
        overflow: 'auto',
    },
    chartContainer: {
        marginLeft: -22,
    },
    tableContainer: {
        height: 320,
    },
    h5: {
        marginBottom: theme.spacing.unit * 2,
    },
});

class Dashboard extends React.Component {
    state = {
        open: false,
        isAuthenticated: false
    };

    componentWillMount()
    {
        let val = sessionStorage.getItem('isAuthenticated');
        this.setState({isAuthenticated:val});
    }

    handleDrawerOpen = () => {
        this.setState({ open: true });
    };

    handleDrawerClose = () => {
        this.setState({ open: false });
    };


    googleResponse = (response) => {
        console.log(response);
        // const tokenBlob = new Blob([JSON.stringify({ access_token: response.accessToken }, null, 2)], { type: 'application/json' });
        // const options = {
        //     method: 'POST',
        //     body: tokenBlob,
        //     mode: 'cors',
        //     cache: 'default'
        // };
        // if (response.accessToken)
        //     this.setState({ isAuthenticated: true });


        // fetch('http://localhost:3000', options).then(r => {
        //     const token = r.headers.get('x-auth-token');
        //     r.json().then(user => {
        //         if (token) {
        //             this.setState({isAuthenticated: true, user, token})
        //         }
        //     });
        // })

        post('http://localhost:3300/api/auth/google-login', JSON.stringify(response.profileObj)).then(
            data => {
              if (data.status === 200) {
                sessionStorage.setItem('sessionID', data.data.sessionID);
                sessionStorage.setItem('userData', JSON.stringify(data.data.user));
                sessionStorage.setItem('isAuthenticated',true);
                this.setState({ isAuthenticated: true });
                // window.location.reload();
              } else {
                alert(data.msg);
              }
            }
          );
    }

    logout = (response) => {
        get('http://localhost:3300/api/auth/google-logout').then(() => {
            sessionStorage.removeItem('sessionID');
            sessionStorage.removeItem('userData');
            sessionStorage.removeItem('isAuthenticated');
            this.setState({ isAuthenticated: false });
            // window.location.reload();
          });

          
        
    }


    render() {
        const { classes } = this.props;

        return (
            <div className={classes.root}>
                <CssBaseline />
                <AppBar
                    position="absolute"
                    className={classNames(classes.appBar, this.state.open && classes.appBarShift)}
                >
                    <Toolbar disableGutters={!this.state.open} className={classes.toolbar}>
                        {this.state.isAuthenticated &&
                        <IconButton
                            color="inherit"
                            aria-label="Open drawer"
                            onClick={this.handleDrawerOpen}
                            className={classNames(
                                classes.menuButton,
                                this.state.open && classes.menuButtonHidden,
                            )}
                        >
                            <MenuIcon />
                        </IconButton>
                        }
                        <Typography
                            component="h1"
                            variant="h6"
                            color="inherit"
                            noWrap
                            className={classes.title}
                        >
                            Dashboard
            </Typography>

                        {
                            !this.state.isAuthenticated &&

                            <GoogleLogin
                                clientId="751630830090-inehifl9rc0tgggaf39m2d6afclu2kft.apps.googleusercontent.com"
                                buttonText="Login"
                                onSuccess={this.googleResponse}
                                onFailure={this.googleResponse}
                            />
                        }
                        {
                            this.state.isAuthenticated &&
                            <GoogleLogout
                                buttonText="Logout"
                                onLogoutSuccess={this.logout}
                            >
                            </GoogleLogout>
                        }
                    </Toolbar>
                </AppBar >
                {
                    this.state.isAuthenticated ?
                        <Drawer
                            variant="permanent"
                            classes={{
                                paper: classNames(classes.drawerPaper, !this.state.open && classes.drawerPaperClose),
                            }}
                            open={this.state.open}
                        >
                            <div className={classes.toolbarIcon}>
                                <IconButton onClick={this.handleDrawerClose}>
                                    <ChevronLeftIcon />
                                </IconButton>
                            </div>
                            <Divider />
                            <List>{mainListItems}</List>
                            <Divider />
                            <List>{secondaryListItems}</List>

                        </Drawer>
                        : null
                }
                {/* <main className={classes.content}>
                    <div className={classes.appBarSpacer} />
                    <Typography variant="h4" gutterBottom component="h2">
                        Menu
                    </Typography>
                    <div align='right'>
                        <FoodFormDialog />
                    </div><br />
                    <div className={classes.tableContainer}>
                        <SimpleTable />
                    </div>
                </main> */}
            </div >
        );
    }
}

Dashboard.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Dashboard);