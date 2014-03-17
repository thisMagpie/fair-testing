
test -z $PROFILEREAD && . /etc/profile || true

unset SSH_ASKPASS

export LANG=en_GB.UTF-8

export PATH=$HOME/.rvm/gems/ruby-2.1.1/bin:$HOME/.rvm/gems/ruby-2.1.1@global/bin:$HOME/.rvm/rubies/ruby-2.1.1/bin:$PATH:/bin:/usr/bin:$HOME/.local/bin:$HOME/.config:/usr/local/bin
export GEM_HOME=$HOME/.rvm/gems/ruby-2.1.1
export GEM_PATH=$HOME/.rvm/gems/ruby-2.1.1:$HOME/.rvm/gems/ruby-2.1.1@global
export MY_RUBY_HOME=$HOME/.rvm/rubies/ruby-2.1.1
export IRBRC=$HOME/.rvm/rubies/ruby-2.1.1/.irbrc
unset MAGLEV_HOME
unset RBXOPT

export GEM_HOME=$HOME/.rvm/gems/ruby-2.1.1
export GEM_PATH=$HOME/.rvm/gems/ruby-2.1.1:$HOME/rvm/gems/ruby-2.1.1@global
 
export PYTHONPATH=$PYTHONPATH:$HOME/.local/share/python2.7
export CPLUS_INCLUDE_PATH=$CPLUS_INCLUDE_PATH:/usr/include/atlas
export C_INCLUDE_PATH=$C_INCLUDE_PATH:/usr/include/atlas
export CMAKE=$CMAKE:/usr/bin/cmake
export RUBYPATH=$RUBYPATH:/usr/bin/ruby:$HOME/rvm/rubies/ruby-2.1.1/bin/ruby
export EDITOR=/usr/bin/vim

export CFLAGS='-g -04'
export CFLAGS=gcc

export MY_RUBY_HOME=$HOME/.rvm/rubies/ruby-2.1.1
export IRBRC=$HOME/.rvm/rubies/ruby-2.1.1/.irbrc
