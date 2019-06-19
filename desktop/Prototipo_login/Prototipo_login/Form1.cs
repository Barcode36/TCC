using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using System.Runtime.InteropServices;

namespace Prototipo_login
{
    public partial class Form1 : Form
    {
        [DllImport("Gdi32.dll", EntryPoint = "CreateRoundRectRgn")]
        private static extern IntPtr CreateRoundRectRgn
         (
             int nLeftRect,
             int nTopRect,
             int nRightRect,
             int nBottomRect,
             int nWidthEllipse,
             int nHeightEllipse
 
         );
       
        Thread nt;
        public Form1()
        {
            InitializeComponent();
            this.FormBorderStyle = FormBorderStyle.None;
            this.Region = System.Drawing.Region.FromHrgn(CreateRoundRectRgn(0, 0, Width, Height, 20, 20));
        }

        private void label1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

              private void label2_Click(object sender, EventArgs e)
        {
            if(Application.OpenForms.OfType<Form2>().Count() == 0)
            {
                Thread nt = new Thread(novoForm);
                nt.SetApartmentState(ApartmentState.STA);
                nt.Start();

            }
            else
            {

                MessageBox.Show("Tela de login já está aberta!", "Atenção", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            
        }

        private void novoForm()
        {
            Application.Run(new Form2());
        }

        private void label6_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }
    }
}
