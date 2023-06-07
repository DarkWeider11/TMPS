using System;
using System.Collections.Generic;
using System.Text;

namespace Lab1.S
{
    public class PC
    {
        private string company;
        private string videocardName;

        public PC(string company, string videocardName)
        {
            this.company = company;
            this.videocardName = videocardName;
        }

        public void TurnOn()
        {
            Console.WriteLine("Turning on!");
            RenderImage();
        }

        public void TurnOff()
        {
            Console.WriteLine("Turning off!");
        }

        public void RenderImage()
        {
            Console.WriteLine("*rendering full-hd video...*");
        }

    }
}
